import java.util.Scanner;

public class NhanSu {
    protected String maSo = "";
    protected String hoTen = "";
    protected String soDienThoai = "";
    protected float soNgayLamViec = 0;
    protected float luongMotNgay = 0;

    public NhanSu() {
    }

    public NhanSu(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgay) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.soNgayLamViec = soNgayLamViec;
        this.luongMotNgay = luongMotNgay;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public float getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(float soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public float getLuongMotNgay() {
        return luongMotNgay;
    }

    public void setLuongMotNgay(float luongMotNgay) {
        this.luongMotNgay = luongMotNgay;
    }

    public float tinhLuong() {
        return this.luongMotNgay * soNgayLamViec;
    }

    public void nhap() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vui lòng nhập mã số nhân sự:");
        this.maSo = scan.nextLine();
        System.out.println("Vui lòng nhập họ tên nhân sự:");
        this.hoTen = scan.nextLine().toUpperCase();
        System.out.println("Vui lòng nhập số điện thoại:");
        this.soDienThoai = scan.nextLine();
        System.out.println("Vui lòng nhập vào số ngày làm việc");
        this.soNgayLamViec = Float.parseFloat(scan.nextLine());
        if(this.soNgayLamViec>31 || this.soNgayLamViec <0) {
            do {
                System.out.println("Vui lòng nhập số ngày làm việc từ 0-31");
                this.soNgayLamViec = Float.parseFloat(scan.nextLine());
            }while (this.soNgayLamViec<0 || this.soNgayLamViec>31);
        }
    }

    public void xuat(int stt) {
        System.out.print(stt+"|\t"+this.maSo+
                "\t"+this.hoTen+
                "\t"+this.soDienThoai+
                "\t"+this.soNgayLamViec);
    }
}
