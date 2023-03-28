package com.se.calc.services;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import com.se.calc.models.Pagamento;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


@Service
public class PagamentoServiceImpl implements PagamentoService{
    @Value("${token.pagamento}")
    private String tokenPagamento;
    @Value("${tipo.pagamento}")
    private String tipoPagamento;
    @SneakyThrows
    @Override
    public String criaPagamento(final Pagamento pagamento) {
        if (pagamento == null){
            throw new IllegalStateException("Informe um pagamento!");
        }
        if (tokenPagamento != null && !tokenPagamento.isEmpty()){

            //Para configurar AcessToken adicione no application.propeties
            MercadoPagoConfig.setAccessToken(tokenPagamento);

            PaymentClient client = new PaymentClient();

            //Cria Request para gerar um pedido de pagamento
            PaymentCreateRequest createRequest =
                    PaymentCreateRequest.builder()
                            .transactionAmount(pagamento.getValorTotalPagamento())
                            .description(pagamento.getDescricaoPagamento())
                            .paymentMethodId(tipoPagamento)
                            .payer(PaymentPayerRequest.builder().email(pagamento.getEmail()).build())
                            .build();
            try {
                //se conseguiu gerar, ele envia a request
                client.create(createRequest);
                return "Venda gerada corretamente, verifique seu email para realizar o pagamento";
            } catch (MPApiException ex) {
                throw new MPApiException(ex.getApiResponse().getContent(), ex.getApiResponse());
            } catch (MPException ex) {
                ex.printStackTrace();
                throw new MPException(ex.getMessage(), ex);
            }
        }

        //Caso não tenha um mercado livre AcessToken configurado, gera QrCode em forma de homologação.
        String url = "Digite_Seu_Link_Aqui";

        // Configurações do QR Code
        int width = 200;
        int height = 200;
        String format = "png";

        // Cria a matriz de bits do QR Code
        BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE,width,height);

        // Converte a matriz de bits em uma imagem BufferedImage
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

        // Converte a imagem em base64
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, format, baos);
        String base64Image = Base64.encodeBase64String(baos.toByteArray());

        return base64Image;
    }
}