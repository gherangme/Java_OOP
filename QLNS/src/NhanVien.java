public class NhanVien extends NhanSu{
    //khai báo thuộc tính
    private TruongPhong truongPhong;

    //hàm khởi tạo
    public NhanVien() {
    }

    public NhanVien(String maSo, String hoTen, String soDienThoai, float soNgayLamViec, float luongMotNgay, TruongPhong truongPhong) {
        super(maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgay);
        this.truongPhong = truongPhong;
    }

    //Getter setter
    public TruongPhong getTruongPhong() {
        return truongPhong;
    }

    public void setTruongPhong(TruongPhong truongPhong) {
        this.truongPhong = truongPhong;
    }

    //set lương tháng nhân viên
    @Override
    public float tinhLuong() {
        setLuongMotNgay(100);
        return this.luongMotNgay * this.soNgayLamViec;
    }

    //xuất nhân viên
    @Override
    public void xuat(int stt) {
        super.xuat(stt);
        System.out.print("\t"+tinhLuong()+"\tNhân viên");
        if(truongPhong == null) {
            System.out.println("\t\t\t\t\tchưa có trưởng phòng");
        }else {
            System.out.println("\t\t\t\t\t"+this.truongPhong.getMaSo());
        }
    }
}
