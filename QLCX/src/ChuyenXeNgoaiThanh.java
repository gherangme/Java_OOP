import java.util.Scanner;

public class ChuyenXeNgoaiThanh extends ChuyenXe{
    private String noiDen;
    private int soNgay;
    final int SO_NGAY = 300;

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public ChuyenXeNgoaiThanh() {
    }

    public ChuyenXeNgoaiThanh(int maSoChuyen, String tenTaiXe, int soXe, float doanhThu, String noiDen, int soNgay) {
        super(maSoChuyen, tenTaiXe, soXe, doanhThu);
        this.noiDen = noiDen;
        this.soNgay = soNgay;
    }

    @Override
    public void nhap() {
        Scanner scan = new Scanner(System.in);
        super.nhap();
        System.out.println("Vui lòng nhập vào nơi đến: ");
        this.noiDen = scan.nextLine();
        System.out.println("Vui lòng nhập vào số ngày");
        this.soNgay = Integer.parseInt(scan.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("\tNơi đến: "+this.noiDen+
                "\tSố ngày: "+this.soNgay);
    }

    @Override
    public float tinhDoanhThu() {
        this.doanhThu = this.soNgay * SO_NGAY;
        return this.doanhThu;
    }
}
