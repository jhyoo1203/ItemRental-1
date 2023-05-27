import usermanagement.LoginManagement;
import util.FontUtil;

import java.awt.*;

public class ItemRentalSystem {
    public static void main(String[] args) {
        String fontName = "맑은 고딕"; // 원하는 폰트 이름으로 변경
        int fontStyle = Font.PLAIN; // 폰트 스타일 설정 (Font.PLAIN, Font.BOLD, Font.ITALIC 등)
        int fontSize = 12; // 폰트 크기 설정

        FontUtil.setUIFont(fontName, fontStyle, fontSize);

        // 로그인 화면 진입
        new LoginManagement();
    }
}
