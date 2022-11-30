import java.sql.SQLOutput;
import java.util.Scanner;

public class CongTy {
    //Khai báo thuộc tính
    private String tenCongTy = null;
    private String maSoThue = null;
    private float doanhThuThang = 0;

    //Hàm khởi tạo
    public CongTy() {
    }

    public CongTy(String tenCongTy, String maSoThue, float doanhThuThang) {
        this.tenCongTy = tenCongTy;
        this.maSoThue = maSoThue;
        this.doanhThuThang = doanhThuThang;
    }

    //Getter setter
    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public float getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(float doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }

    //Hàm nhâp
    public void nhapThongTinCongTy() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào tên công ty:");
        this.tenCongTy = scan.nextLine();
        System.out.println("Vui lòng nhập vào mã số thuế:");
        this.maSoThue = scan.nextLine();
        System.out.println("Vui lòng nhập vào doanh thu tháng:");
        this.doanhThuThang = Float.parseFloat(scan.nextLine());
    }

    //Hàm xuất
    public void xuatThongTinCongTy() {
        System.out.println("\t\t\t\t\t\tTHÔNG TIN CÔNG TY");
        System.out.println("\t\t---------------------------------------------------");
        System.out.println("\t\tTên công ty: "+this.tenCongTy+
                "\n\t\tMã số thuế: "+this.maSoThue+
                "\n\t\tDoanh thu tháng: "+this.doanhThuThang);
        System.out.println("\t\t---------------------------------------------------");
    }
}
