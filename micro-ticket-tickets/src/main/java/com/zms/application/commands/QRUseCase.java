package com.zms.application.commands;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.zms.domain.Constant.Constantes;
import com.zms.infraestructure.qroutputport.QROutputPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class QRUseCase implements QROutputPort {
    @Value("${path.fle}")
    private String pathFile;

    @Override
    public boolean saveQRToDisk(BufferedImage image, String nameFile) {
        try {
            File directory = new File(pathFile);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File qrCodeFile = new File(directory, nameFile + ".jpg");
            ImageIO.write(image, "jpg", qrCodeFile);
            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public BufferedImage generateQR(String id) {
        String data ="http://localhost:8761/api/tickets/validateTicket/" + id;
        System.out.println(">>>>>>>>>>>>>> " + data);
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, Constantes.WIDTH, Constantes.HEIGHT);
            BufferedImage image = new BufferedImage(Constantes.WIDTH, Constantes.HEIGHT, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < Constantes.WIDTH; x++) {
                for (int y = 0; y < Constantes.HEIGHT; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF);
                }
            }
            return image;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
