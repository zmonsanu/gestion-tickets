package com.zms.infraestructure.qroutputport;

import java.awt.image.BufferedImage;

public interface QROutputPort {
    BufferedImage generateQR(String id);

    public boolean saveQRToDisk(BufferedImage image, String nameFile);


}
