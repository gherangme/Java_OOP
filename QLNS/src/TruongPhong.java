public class TruongPhong extends NhanSu{
    //khai báo thuộc tính
    private int soNhanVien = 0;

    //hàm khởi tạo
    public TruongPhong() {
    }

    public TruongPhong(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgay, int soNhanVien) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgay);
        this.soNhanVien = soNhanVien;
    }

    //Getter setter
    public int getSoNhanVien() {
        return soNhanVien;
    }

    public void setSoNhanVien(int soNhanVien) {
        this.soNhanVien = soNhanVien;
    }

    //set lương tháng trưởng phòng
    @Override
    public float tinhLuong() {
        setLuongMotNgay(200);
        return this.luongMotNgay * this.soNgayLamViec + 100 * this.soNhanVien;
    }

    //xuất trưởng phòng
    @Override
    public void xuat(int stt) {
        super.xuat(stt);
        System.out.print("\t"+tinhLuong()+"\tTrưởng phòng");
        System.out.println("\t\t"+this.soNhanVien);
    }
}
