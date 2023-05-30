import usermanagement.LoginManagement;
import util.FontUtil;

public class ItemRentalSystem {
    public static void main(String[] args) {

        // 폰트 설정
        FontUtil.loadFont();

        // 로그인 화면 진입
        new LoginManagement();
    }
}
