package ge.tbc.testautomation.util;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Base64;

import com.codeborne.selenide.SelenideElement;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.NotFoundException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import ge.tbc.testautomation.steps.loansSteps;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;
import static ge.tbc.testautomation.constants.Consts.CITY_WITHOUT_ANY;

public class Helper {


    public static boolean isKnownEmpty(String filter) {
        //known empty cities that i found(why no branches and atms here??  (6_6) )
        String[] empty = {CITY_WITHOUT_ANY};

        for (String emptyFilter : empty) {
            if (emptyFilter.equalsIgnoreCase(filter)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCurrentTimeWithinStandardHours() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalTime currentTime = now.toLocalTime();

        LocalTime openTime = LocalTime.of(10, 0);

        if (dayOfWeek.getValue() >= 1 && dayOfWeek.getValue() <= 5) {
            LocalTime closeTime = LocalTime.of(18, 0);
            return !currentTime.isBefore(openTime) && currentTime.isBefore(closeTime);
        }
        else if (dayOfWeek == DayOfWeek.SATURDAY) {
            LocalTime closeTime = LocalTime.of(14, 0);
            return !currentTime.isBefore(openTime) && currentTime.isBefore(closeTime);
        }
        // Sunday
        else {
            return false;
        }
    }
    public static String extractQrFromCanvas(SelenideElement canvasElement) {
        try {
            // Get Base64 PNG from canvas via JS
            String dataUrl = executeJavaScript("return arguments[0].toDataURL('image/png');", canvasElement);
            String base64Image = dataUrl.split(",")[1];
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            // Decode directly from memory
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageBytes));
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();

        } catch (NotFoundException e) {
            System.err.println("No QR code found in the canvas");
            return null;
        } catch (IOException e) {
            throw new RuntimeException(" Failed to read QR image", e);
        }
    }

    public static void closeTab(){

        switchTo().window(1);

        switchTo().window(0);
        closeWindow();

        switchTo().window(0);
    }
}

