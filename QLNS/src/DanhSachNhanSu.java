import java.util.ArrayList;
import java.util.List;

public class DanhSachNhanSu {
    //khai báo thuộc tính
    public List<NhanVien> danhSachNhanVien;
    public List<TruongPhong> danhSachTruongPhong;
    public List<GiamDoc> danhSachGiamDoc;
    public float tongLuongToanCongTy = 0;
    public float tongCoPhan = 0;

    //hàm khởi tạo
    public DanhSachNhanSu() {
        this.danhSachNhanVien = new ArrayList<NhanVien>();
        this.danhSachTruongPhong = new ArrayList<TruongPhong>();
        this.danhSachGiamDoc = new ArrayList<GiamDoc>();
    }

    //Getter setter

    public List<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public List<TruongPhong> getDanhSachTruongPhong() {
        return danhSachTruongPhong;
    }

    public void setDanhSachTruongPhong(List<TruongPhong> danhSachTruongPhong) {
        this.danhSachTruongPhong = danhSachTruongPhong;
    }

    public List<GiamDoc> getDanhSachGiamDoc() {
        return danhSachGiamDoc;
    }

    public void setDanhSachGiamDoc(List<GiamDoc> danhSachGiamDoc) {
        this.danhSachGiamDoc = danhSachGiamDoc;
    }

    public float getTongLuongToanCongTy() {
        return tongLuongToanCongTy;
    }

    public void setTongLuongToanCongTy(float tongLuongToanCongTy) {
        this.tongLuongToanCongTy = tongLuongToanCongTy;
    }

    //thêm nhân viên
    public void themNhanVien(NhanVien nhanVien) {
        this.danhSachNhanVien.add(nhanVien);
        System.out.println("Thêm thành công");
    }

    //xóa nhân viên
    public void xoaNhanVien(String maSo) {
        List<NhanVien> rem = new ArrayList<NhanVien>();
        for (NhanVien nhanVien : this.danhSachNhanVien) {
            if (nhanVien.getMaSo().equals(maSo)) {
                rem.add(nhanVien);
            }
        }
        if (rem.size() == 0) {
            System.out.println("Không tồn tại nhân viên này");

        } else {

            this.danhSachNhanVien.removeAll(rem);
            System.out.println("Đã xóa thành công nhân viên này");
        }
    }

    //thêm trưởng phòng
    public void themTruongPhong(TruongPhong truongPhong) {
        this.danhSachTruongPhong.add(truongPhong);
        System.out.println("Thêm thành công");
    }

    //xóa trưởng phòng
    public void xoaTruongPhong(String maSo) {
        List<NhanVien> nhanVienNotNull = new ArrayList<NhanVien>();
        TruongPhong rem = null;
        for (TruongPhong truongPhong : this.danhSachTruongPhong) {
            if (truongPhong.getMaSo().equals(maSo)) {
                rem = truongPhong;
            }
        }
        if (rem == null) {
            System.out.println("Không tồn tại trưởng phòng này");
        } else {
            /*
            trong this.danhSachNhanVien gồm 2 loại: NhanVien có trưởng phòng null và không null
            giải thuật:
            - thêm toàn bộ NhanVien không null vào List nhanVienNotNull
            - tìm tất cả NhanVien trong List nhanVienNotNull có maSo TruongPhong giống maSo của TruongPhong rem và gán bằng null
            - duyệt lại this.danhSachNhanVien và swap List nhanVienNotNull vào danhSachNhanVien
             */
            for (NhanVien nhanVien : this.danhSachNhanVien) {
                if (nhanVien.getTruongPhong() != null) {
                    nhanVienNotNull.add(nhanVien);
                }
            }
            for (NhanVien nhanVien_NotNull : nhanVienNotNull) {
                if (rem.getMaSo().equals(nhanVien_NotNull.getTruongPhong().getMaSo())) {
                    nhanVien_NotNull.setTruongPhong(null);
                    for (NhanVien nhanVien : this.danhSachNhanVien) {
                        if (nhanVien_NotNull.getMaSo().equals(nhanVien_NotNull.getMaSo())) {
                            nhanVien = nhanVien_NotNull;
                        }
                    }
                }
            }
            this.danhSachTruongPhong.remove(rem);
            System.out.println("Đã xóa thành công trưởng phòng này");
        }
    }

    //thêm giám đốc
    public void themGiamDoc(GiamDoc giamDoc) {
        this.tongCoPhan = 0;
        for(GiamDoc coPhanGiamDoc: this.danhSachGiamDoc) {
            this.tongCoPhan += coPhanGiamDoc.getSoCoPhan();
        }
        this.tongCoPhan += giamDoc.getSoCoPhan();
        if(this.tongCoPhan<=100) {
            this.danhSachGiamDoc.add(giamDoc);
            System.out.println("Thêm thành công");
        }else {
            System.out.println("Thêm không thành công\nTổng cổ phần > 100(phần trăm)");
        }
    }

    //xóa giám đốc
    public void xoaGiamDoc(String maSo) {
        List<GiamDoc> rem = new ArrayList<GiamDoc>();
        for (GiamDoc giamDoc : this.danhSachGiamDoc) {
            if (giamDoc.getMaSo().equals(maSo)) {
                rem.add(giamDoc);
            }
        }
        if (rem.size() == 0) {
            System.out.println("Không tồn tại giám đốc này");
        } else {
            this.danhSachGiamDoc.removeAll(rem);
            System.out.println("Đã xóa thành công giám đốc này");
        }
    }

    //xuất thông tin toàn bộ người trong công ty
    public void xuatThongTinToanCongTy() {
        int stt = 0;
        System.out.println("\t\t\t\t\t\t\t\t\t\tTHÔNG TIN TOÀN CÔNG TY");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("STT\tMã số\tHọ và tên\tĐiện thoại\tSố ngày\tLương\tChức vụ\t\t%CP\t\tSố NV\tTrưởng phòng");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for (GiamDoc giamDoc : this.danhSachGiamDoc) {
            stt++;
            giamDoc.xuat(stt);
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
        for (TruongPhong truongPhong : this.danhSachTruongPhong) {
            stt++;
            truongPhong.xuat(stt);
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
        for (NhanVien nhanVien : this.danhSachNhanVien) {
            stt++;
            nhanVien.xuat(stt);
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
    }

    //tính và xuất tổng lương toàn công ty
    public float tinhTongLuongToanCongTy() {
        this.tongLuongToanCongTy = 0;
        for (GiamDoc giamDoc : this.danhSachGiamDoc) {
            this.tongLuongToanCongTy += giamDoc.tinhLuong();
        }
        for (NhanVien nhanVien : this.danhSachNhanVien) {
            this.tongLuongToanCongTy += nhanVien.tinhLuong();
        }
        for (TruongPhong truongPhong : this.danhSachTruongPhong) {
            this.tongLuongToanCongTy += truongPhong.tinhLuong();
        }
        return this.tongLuongToanCongTy;
    }

    //tìm nhân viên lương cao nhất
    public void nhanVienLuongCaoNhat() {
        int stt = 0;
        List<NhanVien> danhSachNhanVienMax = new ArrayList<NhanVien>();
        NhanVien nhanVienMax;
        nhanVienMax = this.danhSachNhanVien.get(0);
        System.out.println("\t\t\t\t\t\tDANH SÁCH NHÂN VIÊN THƯỜNG LƯƠNG CAO NHẤT THÁNG");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("STT\tMã số\tHọ và tên\tĐiện thoại\tSố ngày\tLương\tChức vụ\t\t%CP\t\tSố NV\tTrưởng phòng");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for (NhanVien nhanVien : this.danhSachNhanVien) {
            if (nhanVienMax.tinhLuong() < nhanVien.tinhLuong()) {
                nhanVienMax = nhanVien;
            }
        }
        for (NhanVien nhanVien : this.danhSachNhanVien) {
            if (nhanVien.tinhLuong() == nhanVienMax.tinhLuong()) {
                danhSachNhanVienMax.add(nhanVien);
            }
        }
        for (NhanVien nhanVien : danhSachNhanVienMax) {
            stt++;
            nhanVien.xuat(stt);
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
    }

    //phân bổ nhân viên vào trưởng phòng
    public void phanBoNhanVienVaoTruongPhong(String maSoTruongPhong, String maSoNhanVien) {
        boolean flag = false;
        TruongPhong truong_Phong = null;
        NhanVien nhan_Vien = null;
        for (TruongPhong truongPhong : this.danhSachTruongPhong) {
            if (truongPhong.getMaSo().equals(maSoTruongPhong)) {
                truong_Phong = truongPhong;
                flag = true;
            }
        }
        if (flag) {
            for (NhanVien nhanVien : this.danhSachNhanVien) {
                if (nhanVien.getMaSo().equals(maSoNhanVien)) {
                    nhan_Vien = nhanVien;
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Không tồn tại nhân viên này");
            } else {
                nhan_Vien.setTruongPhong(truong_Phong);
                System.out.println("Phân bổ thành công");
            }
        } else {
            System.out.println("Không tồn tại trưởng phòng này");
        }
    }

    //Số lượng nhân viên dưới quyền của toàn trưởng phòng
    public void capNhatSoLuongNhanVienDuoiQuyen() {
        for (TruongPhong truongPhong : this.danhSachTruongPhong) {
            int soLuong = 0;
            for (NhanVien nhanVien : this.danhSachNhanVien) {
                if (nhanVien.getTruongPhong() != null) {
                    if (nhanVien.getTruongPhong().getMaSo().equals(truongPhong.getMaSo())) {
                        soLuong++;
                    }
                }
            }
            truongPhong.setSoNhanVien(soLuong);
        }
    }

    //Tìm trưởng phòng có số nhân viên dưới quyền nhiều nhất
    public void truongPhongCoNhanVienDuoiQuyenNhieuNhat() {
        int stt = 0;
        TruongPhong truongPhongMax = this.danhSachTruongPhong.get(0);
        for (TruongPhong truongPhong : this.danhSachTruongPhong) {
            if (truongPhongMax.getSoNhanVien() < truongPhong.getSoNhanVien()) {
                truongPhongMax = truongPhong;
            }
        }
        stt++;
        truongPhongMax.xuat(stt);
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    //sắp xếp theo danh sách abc
    public void xuatDanhSachTenTheoThuTuABC() {
        int stt = 0;
        System.out.println("\t\t\t\t\t\tXUẤT DANH SÁCH THEO THỨ TỰ ABC");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("STT\tMã số\tHọ và tên\tĐiện thoại\tSố ngày\tLương\tChức vụ\t\t%CP\t\tSố NV\tTrưởng phòng");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for (int i = 65; i < 91; i++) {
            for (GiamDoc giamDoc : this.danhSachGiamDoc) {
                char[] c = giamDoc.getHoTen().toCharArray();
                if (c[0] == i) {
                    stt++;
                    giamDoc.xuat(stt);
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                }
            }
            for (NhanVien nhanVien : this.danhSachNhanVien) {
                char[] c = nhanVien.getHoTen().toCharArray();
                if (c[0] == i) {
                    stt++;
                    nhanVien.xuat(stt);
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                }
            }
            for (TruongPhong truongPhong : this.danhSachTruongPhong) {
                char[] c = truongPhong.getHoTen().toCharArray();
                if (c[0] == i) {
                    stt++;
                    truongPhong.xuat(stt);
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                }
            }
        }
    }

    //sắp xếp lương giảm dần
    public void sapXepLuongGiamDan() {
        int stt = 0;
        System.out.println("\t\t\t\t\t\t\t\tDANH SÁCH XẾP THEO LƯƠNG GIẢM DẦN");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("STT\tMã số\tHọ và tên\tĐiện thoại\tSố ngày\tLương\tChức vụ\t\t%CP\t\tSố NV\tTrưởng phòng");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        float[] arr = new float[this.danhSachTruongPhong.size() + this.danhSachNhanVien.size() + this.danhSachGiamDoc.size()];
        float temp = 0;
        for (int i = 0; i < this.danhSachTruongPhong.size(); i++) {
            arr[i] = this.danhSachTruongPhong.get(i).tinhLuong();
        }
        for (int i = this.danhSachTruongPhong.size(); i < (this.danhSachTruongPhong.size() + this.danhSachNhanVien.size()); i++) {
            arr[i] = this.danhSachNhanVien.get(i - this.danhSachTruongPhong.size()).tinhLuong();
        }
        for (int i = (this.danhSachTruongPhong.size() + this.danhSachNhanVien.size()); i < (this.danhSachTruongPhong.size() + this.danhSachNhanVien.size() + this.danhSachGiamDoc.size()); i++) {
            arr[i] = this.danhSachGiamDoc.get(i - (this.danhSachTruongPhong.size() + this.danhSachNhanVien.size())).tinhLuong();
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for (int i = 0; i < (arr.length-1); i++) {
            if(arr[i]!=arr[i+1]) {
                for (NhanVien nhanVien : this.danhSachNhanVien) {
                    if (nhanVien.tinhLuong() == arr[i]) {
                        stt++;
                        nhanVien.xuat(stt);
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                    }
                }
                for (GiamDoc giamDoc : this.danhSachGiamDoc) {
                    if (giamDoc.tinhLuong() == arr[i]) {
                        stt++;
                        giamDoc.xuat(stt);
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                    }
                }
                for (TruongPhong truongPhong : this.danhSachTruongPhong) {
                    if (truongPhong.tinhLuong() == arr[i]) {
                        stt++;
                        truongPhong.xuat(stt);
                        System.out.println("--------------------------------------------------------------------------------------------------------");
                    }
                }
            }
        }
        if(arr[arr.length-2]==arr[arr.length-1]) {
            for (NhanVien nhanVien : this.danhSachNhanVien) {
                if (nhanVien.tinhLuong() == arr[arr.length-1]) {
                    stt++;
                    nhanVien.xuat(stt);
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                }
            }
            for (GiamDoc giamDoc : this.danhSachGiamDoc) {
                if (giamDoc.tinhLuong() == arr[arr.length-1]) {
                    stt++;
                    giamDoc.xuat(stt);
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                }
            }
            for (TruongPhong truongPhong : this.danhSachTruongPhong) {
                if (truongPhong.tinhLuong() == arr[arr.length-1]) {
                    stt++;
                    truongPhong.xuat(stt);
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                }
            }
        }
    }

    //Giám đốc có số cổ phần nhiều nhất
    public void coPhanNhieuNhat() {
        int stt = 0;
        System.out.println("\t\t\t\t\t\tGIÁM ĐỐC CÓ SỐ CỔ PHẦN NHIỀU NHẤT");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("STT\tMã số\tHọ và tên\tĐiện thoại\tSố ngày\tLương\tChức vụ\t\t%CP\t\tSố NV\tTrưởng phòng");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        GiamDoc giamDocMax = this.danhSachGiamDoc.get(0);
        for(GiamDoc giamDoc: this.danhSachGiamDoc) {
            if(giamDocMax.getSoCoPhan()<giamDoc.getSoCoPhan()) {
                giamDocMax = giamDoc;
            }
        }
        stt++;
        giamDocMax.xuat(stt);
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }

    //Xuất tổng thu nhập từng giám đốc
    public void tongThuNhapTungGiamDoc(CongTy congTy) {
        int stt = 0;
        float loiNhuanCongTy = congTy.getDoanhThuThang() - tinhTongLuongToanCongTy();
        for(GiamDoc giamDoc: this.danhSachGiamDoc) {
            giamDoc.setTongThuNhap(giamDoc.tinhLuong() + (giamDoc.getSoCoPhan()/100) * loiNhuanCongTy);
        }
        System.out.println("\t\t\t\t\tTỔNG THU NHẬP CỦA TỪNG GIÁM ĐỐC");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("STT\tMã số\tHọ và tên\tTổng thu nhập");
        for(GiamDoc giamDoc: this.danhSachGiamDoc) {
            stt++;
            System.out.println(stt+"|\t"+giamDoc.getMaSo()+"\t"+giamDoc.getHoTen()+"\t"+giamDoc.getTongThuNhap());
            System.out.println("------------------------------------------------------------------------");
        }
    }
}
