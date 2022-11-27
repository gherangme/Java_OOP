import javax.swing.*;
import java.util.Scanner;

public class ChuyenXeNoiThanh extends ChuyenXe{
    private int soTuyen;
    private int soKm;
    final int SO_TIEN_1_KM = 100;

    public int getSoTuyen() {
        return soTuyen;
    }

    public void setSoTuyen(int soTuyen) {
        this.soTuyen = soTuyen;
    }

    public int getSoKm() {
        return soKm;
    }

    public void setSoKm(int soKm) {
        this.soKm = soKm;
    }

    public ChuyenXeNoiThanh() {
    }

    public ChuyenXeNoiThanh(int maSoChuyen, String tenTaiXe, int soXe, float doanhThu, int soTuyen, int soKm) {
        super(maSoChuyen, tenTaiXe, soXe, doanhThu);
        this.soTuyen = soTuyen;
        this.soKm = soKm;
    }

    @Override
    public void nhap() {
        Scanner scan = new Scanner(System.in);
        super.nhap();
        System.out.println("Vui lòng nhập vào số tuyến: ");
        this.soTuyen = Integer.parseInt(scan.nextLine());
        System.out.println("Vui lòng nhập vào số km");
        this.soKm = Integer.parseInt(scan.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("\tSố tuyến: "+this.soTuyen+
                "\tSố km: "+this.soKm);
    }

    @Override
    public float tinhDoanhThu() {
        this.doanhThu = this.soKm * SO_TIEN_1_KM;
        return this.doanhThu;
    }
}
