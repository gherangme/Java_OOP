import java.util.ArrayList;
import java.util.List;

public class DanhSachChuyenXe {
    private List<ChuyenXe> danhSachChuyenXe;
    private float tongDoanhThuNoiThanh = 0;
    private float tongDoanhThuNgoaiThanh = 0;
    private float tongDoanhThu = 0;

    public List<ChuyenXe> getDanhSachChuyenXe() {
        return danhSachChuyenXe;
    }

    public void setDanhSachChuyenXe(List<ChuyenXe> danhSachChuyenXe) {
        this.danhSachChuyenXe = danhSachChuyenXe;
    }

    public float getTongDoanhThuNoiThanh() {
        return tongDoanhThuNoiThanh;
    }

    public void setTongDoanhThuNoiThanh(float tongDoanhThuNoiThanh) {
        this.tongDoanhThuNoiThanh = tongDoanhThuNoiThanh;
    }

    public float getTongDoanhThuNgoaiThanh() {
        return tongDoanhThuNgoaiThanh;
    }

    public void setTongDoanhThuNgoaiThanh(float tongDoanhThuNgoaiThanh) {
        this.tongDoanhThuNgoaiThanh = tongDoanhThuNgoaiThanh;
    }

    public float getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(float tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public DanhSachChuyenXe() {
        this.danhSachChuyenXe = new ArrayList<ChuyenXe>();
    }

    public DanhSachChuyenXe(List<ChuyenXe> danhSachChuyenXe, float tongDoanhThuNoiThanh, float tongDoanhThuNgoaiThanh, float tongDoanhThu) {
        this.danhSachChuyenXe = danhSachChuyenXe;
        this.tongDoanhThuNoiThanh = tongDoanhThuNoiThanh;
        this.tongDoanhThuNgoaiThanh = tongDoanhThuNgoaiThanh;
        this.tongDoanhThu = tongDoanhThu;
    }

    public float tinhTongDoanhThuNoiThanh() {
        return this.tongDoanhThuNoiThanh = 0;
        for (ChuyenXe chuyenXe:
             this.danhSachChuyenXe) {
            if(chuyenXe instanceof ChuyenXeNoiThanh) {
                this.tongDoanhThuNoiThanh += chuyenXe.getDoanhThu();
            }
        }
        return this.tongDoanhThuNoiThanh;
    }

    public float tinhTongDoanhThuNgoaiThanh() {
        this.tongDoanhThuNgoaiThanh = 0;
        for (ChuyenXe chuyenXe:
                this.danhSachChuyenXe) {
            if(chuyenXe instanceof ChuyenXeNgoaiThanh) {
                this.tongDoanhThuNgoaiThanh += chuyenXe.getDoanhThu();
            }
        }
        return this.tongDoanhThuNgoaiThanh;
    }

    public void themChuyenXe(ChuyenXe chuyenXe) {
        this.danhSachChuyenXe.add(chuyenXe);
    }

    public void tinhTongDoanhThu() {
        this.tongDoanhThu = this.tongDoanhThuNgoaiThanh + this.tongDoanhThuNoiThanh;
        System.out.println("Tổng doanh thu: "+this.tongDoanhThu);
    }

    public void xuatChuyenXe() {
        for (ChuyenXe chuyenXe: this.danhSachChuyenXe) {
            if(chuyenXe instanceof ChuyenXeNoiThanh) {
                chuyenXe.xuat();
            }
        }

        for (ChuyenXe chuyenXe: this.danhSachChuyenXe) {
            if(chuyenXe instanceof ChuyenXeNgoaiThanh) {
                chuyenXe.xuat();
            }
        }
    }
}
