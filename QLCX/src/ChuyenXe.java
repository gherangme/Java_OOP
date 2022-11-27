import java.util.Scanner;

public class ChuyenXe {
    protected int maSoChuyen;
    protected String tenTaiXe;
    protected int soXe;
    protected float doanhThu = 0;

    public int getMaSoChuyen() {
        return maSoChuyen;
    }

    public void setMaSoChuyen(int maSoChuyen) {
        this.maSoChuyen = maSoChuyen;
    }

    public String getTenTaiXe() {
        return tenTaiXe;
    }

    public void setTenTaiXe(String tenTaiXe) {
        this.tenTaiXe = tenTaiXe;
    }

    public int getSoXe() {
        return soXe;
    }

    public void setSoXe(int soXe) {
        this.soXe = soXe;
    }

    public float getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(float doanhThu) {
        this.doanhThu = doanhThu;
    }

    public void nhap() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào mã số chuyến");
        this.maSoChuyen =  Integer.parseInt(scan.nextLine());
        System.out.println("Vui lòng nhập vào tên tài xế");
        this.tenTaiXe = scan.nextLine();
        System.out.println("Vui lòng nhập vào số xe");
        this.soXe = Integer.parseInt(scan.nextLine());
    }

    public void xuat() {
        System.out.print("Mã số chuyến: "+this.maSoChuyen+
                "\tTên tài xế: "+this.tenTaiXe+
                "\tSố xe: "+this.soXe);
    }

    public ChuyenXe() {
    }

    public ChuyenXe(int maSoChuyen, String tenTaiXe, int soXe, float doanhThu) {
        this.maSoChuyen = maSoChuyen;
        this.tenTaiXe = tenTaiXe;
        this.soXe = soXe;
        this.doanhThu = doanhThu;
    }

    public float tinhDoanhThu() {
        return this.doanhThu;
    }
}
