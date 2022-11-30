import java.util.Scanner;

public class GiamDoc extends NhanSu{
    //khai báo thuộc tính
    private float soCoPhan = 0;
    public float tongThuNhap = 0;

    //hàm khởi tạo
    public GiamDoc() {
    }

    public GiamDoc(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgay, float soCoPhan) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgay);
        this.soCoPhan = soCoPhan;
    }

    //Getter setter
    public float getSoCoPhan() {
        return soCoPhan;
    }

    public void setSoCoPhan(float soCoPhan) {
        this.soCoPhan = soCoPhan;
    }

    public float getTongThuNhap() {
        return tongThuNhap;
    }

    public void setTongThuNhap(float tongThuNhap) {
        this.tongThuNhap = tongThuNhap;
    }

    //set lương tháng giám đốc
    @Override
    public float tinhLuong() {
        setLuongMotNgay(300);
        return this.luongMotNgay * this.soNgayLamViec;
    }

    //hàm nhập
    @Override
    public void nhap() {
        Scanner scan = new Scanner(System.in);
        super.nhap();
        System.out.println("Vui lòng nhập vào số cổ phần");
        this.soCoPhan = Float.parseFloat(scan.nextLine());
        if(this.soCoPhan>100 || this.soCoPhan <0) {
            do {
                System.out.println("Tổng số cổ phần từ 0-100");
                this.soCoPhan = Float.parseFloat(scan.nextLine());
            }while (this.soCoPhan>100 || this.soCoPhan <0);
        }
    }

    //xuất giám đốc

    @Override
    public void xuat(int stt) {
        super.xuat(stt);
        System.out.print("\t"+tinhLuong()+"\tGiám đốc");
        System.out.println("\t"+this.soCoPhan+"%");
    }
}
