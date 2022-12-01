import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //khai báo biến, đối tượng, danh sách
        Scanner scan = new Scanner(System.in);
        CongTy congTy = new CongTy();
        DanhSachNhanSu danhSachNhanSu = new DanhSachNhanSu();
        int demNhanVien = 0, demTruongPhong = 0, demGiamDoc = 0;
        boolean flag = false;
        /*
        danh sách có 11 người gồm: 8 nhân viên, 2 trưởng phòng, 1 giám đốc
        (nhân viên chưa có trưởng phòng)
         */
        NhanVien nhanVien1 = new NhanVien("NV001", "NGỌC HÙNG", "0763456789", 25, 100, null);
        NhanVien nhanVien2 = new NhanVien("NV002", "BẢO DUY", "0763456788", 24, 100, null);
        NhanVien nhanVien3 = new NhanVien("NV003", "TUẤN KIỆT", "0763456787", 23, 100, null);
        NhanVien nhanVien4 = new NhanVien("NV004", "ANH TUẤN", "0763456786", 22, 100, null);
        NhanVien nhanVien5 = new NhanVien("NV005", "NGỌC HÙNG", "0763456785", 25, 100, null);
        NhanVien nhanVien6 = new NhanVien("NV006", "TRÂN CHÂU", "0763456784", 24, 100, null);
        NhanVien nhanVien7 = new NhanVien("NV007", "TÀI PHƯỚC", "0763456783", 23, 100, null);
        NhanVien nhanVien8 = new NhanVien("NV008", "MEO MEO", "0763456782", 22, 100, null);
        TruongPhong truongPhong1 = new TruongPhong("TP001", "QUỐC HUY", "0763456781", 30, 300, 0);
        TruongPhong truongPhong2 = new TruongPhong("TP002", "HOÀNG HUY", "0763456780", 28, 300, 0);
        GiamDoc giamDoc1 = new GiamDoc("GD001", "CYBERSOFT", "0763456779", 20, 300, 45.5f);
        danhSachNhanSu.danhSachNhanVien.add(nhanVien1);
        danhSachNhanSu.danhSachNhanVien.add(nhanVien2);
        danhSachNhanSu.danhSachNhanVien.add(nhanVien3);
        danhSachNhanSu.danhSachNhanVien.add(nhanVien4);
        danhSachNhanSu.danhSachNhanVien.add(nhanVien5);
        danhSachNhanSu.danhSachNhanVien.add(nhanVien6);
        danhSachNhanSu.danhSachNhanVien.add(nhanVien7);
        danhSachNhanSu.danhSachNhanVien.add(nhanVien8);
        danhSachNhanSu.danhSachTruongPhong.add(truongPhong1);
        danhSachNhanSu.danhSachTruongPhong.add(truongPhong2);
        danhSachNhanSu.danhSachGiamDoc.add(giamDoc1);

        //Code xử lý
        do {
            //thông báo chức năng
            thongBao();
            System.out.println("Vui lòng chọn chức năng: ");
            int chon = Integer.parseInt(scan.nextLine());
            switch (chon) {
                case 1:
                    //Input/Output thông tin công ty
                    if(congTy.getTenCongTy()==null) {
                        System.out.println("Chưa có thông tin công ty");
                        congTy.nhapThongTinCongTy();
                        congTy.xuatThongTinCongTy();
                    }else {
                        congTy.xuatThongTinCongTy();
                    }
                    break;
                case 2:
                    //Phân trưởng phòng cho nhân viên
                    System.out.println("Vui lòng nhập mã trưởng phòng");
                    String maSoTruongPhong = scan.nextLine();
                    System.out.println("Vui lòng nhập mã nhân viên muốn phân bổ");
                    String maSoNhanVien = scan.nextLine();
                    danhSachNhanSu.phanBoNhanVienVaoTruongPhong(maSoTruongPhong, maSoNhanVien);
                    danhSachNhanSu.capNhatSoLuongNhanVienDuoiQuyen();
                    break;
                case 3:
                    //thêm/xóa nhân sự
                    thongBaoThemXoa();
                    int luaChon = Integer.parseInt(scan.nextLine());
                    switch (luaChon) {
                        //Thêm 1 nhân viên
                        case 1:
                            NhanVien[] nhanVienThem = new NhanVien[100];
                            nhanVienThem[demNhanVien] = new NhanVien();
                            nhanVienThem[demNhanVien].nhap();
                            boolean flag_1 = true;

                            //check tồn tại mã nhân viên, nếu chưa sẽ thêm vào
                            for (NhanVien nhanVien: danhSachNhanSu.danhSachNhanVien) {
                                if(nhanVienThem[demNhanVien].getMaSo().equals(nhanVien.getMaSo())) {
                                    flag_1 = false;
                                }
                            }
                            if(flag_1) {
                                danhSachNhanSu.themNhanVien(nhanVienThem[demNhanVien]);
                                demNhanVien++;
                            }else {
                                System.out.println("Thêm không thành công.\nMã nhân viên này đã tồn tại");
                            }
                            break;

                        //xóa 1 nhân viên
                        case 2:
                            System.out.println("Nhập mã nhân viên để xóa");
                            String xoaNhanVien = scan.nextLine();
                            danhSachNhanSu.xoaNhanVien(xoaNhanVien);
                            break;

                        //Thêm 1 trưởng phòng
                        case 3:
                            TruongPhong[] truongPhongThem = new TruongPhong[100];
                            truongPhongThem[demTruongPhong] = new TruongPhong();
                            truongPhongThem[demTruongPhong].nhap();
                            boolean flag_2 = true;

                            //check tồn tại mã trưởng phòng
                            for (TruongPhong truongPhong: danhSachNhanSu.danhSachTruongPhong) {
                                if(truongPhong.getMaSo().equals(truongPhongThem[demTruongPhong].getMaSo())) {
                                    flag_2 = false;
                                }
                            }
                            if(flag_2) {
                                danhSachNhanSu.themTruongPhong(truongPhongThem[demTruongPhong]);
                                demTruongPhong++;
                            }else {
                                System.out.println("Thêm không thành công.\nMã trưởng phòng này đã tồn tại");
                            }
                            break;

                        //Xóa 1 trưởng phòng
                        case 4:
                            System.out.println("Nhập mã trưởng phòng để xóa");
                            String xoaTruongPhong = scan.nextLine();
                            danhSachNhanSu.xoaTruongPhong(xoaTruongPhong);
                            break;

                        //Thêm 1 giám đốc
                        case 5:
                            GiamDoc[] giamDocThem = new GiamDoc[100];
                            giamDocThem[demGiamDoc] = new GiamDoc();
                            giamDocThem[demGiamDoc].nhap();
                            boolean flag_3 = true;

                            //check tồn tại mã giám đốc
                            for (GiamDoc giamDoc: danhSachNhanSu.danhSachGiamDoc) {
                                if(giamDoc.getMaSo().equals(giamDocThem[demGiamDoc].getMaSo())) {
                                    flag_3 = false;
                                }
                            }
                            if(flag_3) {
                                danhSachNhanSu.themGiamDoc(giamDocThem[demGiamDoc]);
                                demGiamDoc++;
                            }else {
                                System.out.println("Thêm không thành công.\nMã giám đốc này đã tồn tại");
                            }
                            break;

                        //Xóa 1 giám đốc
                        case 6:
                            System.out.println("Nhập mã giám đốc để xóa");
                            String xoaGiamDoc = scan.nextLine();
                            danhSachNhanSu.xoaGiamDoc(xoaGiamDoc);
                            break;
                        default:
                            System.out.println("Đã hủy");
                            break;
                    }
                    //cập nhật lại số lượng nhân viên của trưởng phòng sau khi xóa
                    danhSachNhanSu.capNhatSoLuongNhanVienDuoiQuyen();
                    break;
                case 4:
                    //Output danh sách toàn công ty
                    danhSachNhanSu.xuatThongTinToanCongTy();
                    break;
                case 5:
                    //Output tổng lương toàn nhân sự
                    System.out.println("Tổng lương toàn công ty: "+danhSachNhanSu.tinhTongLuongToanCongTy());
                    break;
                case 6:
                    //Output danh sách nhân viên lương cao nhất
                    danhSachNhanSu.nhanVienLuongCaoNhat();
                    break;
                case 7:
                    //Output trưởng phòng có lượng nhân viên nhiều nhất
                    System.out.println("\t\t\t\t\tTRƯỞNG PHÒNG CÓ SỐ NHÂN VIÊN DƯỚI QUYỀN NHIỀU NHẤT");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.println("STT\tMã số\tHọ và tên\tĐiện thoại\tSố ngày\tLương\tChức vụ\t\t%CP\t\tSố NV\tTrưởng phòng");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    danhSachNhanSu.capNhatSoLuongNhanVienDuoiQuyen();
                    danhSachNhanSu.truongPhongCoNhanVienDuoiQuyenNhieuNhat();
                    break;
                case 8:
                    //Output tên theo ABC
                    danhSachNhanSu.xuatDanhSachTenTheoThuTuABC();
                    break;
                case 9:
                    //Output lương giảm dần
                    danhSachNhanSu.sapXepLuongGiamDan();
                    break;
                case 10:
                    //Giám đốc có cổ phần nhiều nhất
                    danhSachNhanSu.coPhanNhieuNhat();
                    break;
                case 11:
                    //Output tổng thu nhập từng giám đốc
                    danhSachNhanSu.tongThuNhapTungGiamDoc(congTy);
                    break;
                default:
                    //thông báo thoát
                    System.out.println("Thoát chương trình");
                    flag = true;
                    break;
            }
        }while(!flag);
    }

    //thông báo chức năng
    public static void thongBao() {
        System.out.println("\t\t\t\t\tQUẢN LÝ NHÂN SỰ"+
                "\n\t\t\t1.Nhập/xuất thông tin công ty"+
                "\n\t\t\t2.Phân bổ nhân viên vào trưởng phòng"+
                "\n\t\t\t3.Thêm, xóa một nhân sự"+
                "\n\t\t\t4.Xuất thông tin toàn bộ người trong công ty"+
                "\n\t\t\t5.Xuất tổng lương cho toàn công ty"+
                "\n\t\t\t6.Nhân viên thường có lương nhất"+
                "\n\t\t\t7.Trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất"+
                "\n\t\t\t8.Xuất nhân viên toàn công ty theo thứ tự ABC"+
                "\n\t\t\t9.Xuất nhân viên toàn công ty theo thứ tự lương giảm dần"+
                "\n\t\t\t10.Xuất giám Đốc có số lượng cổ phần nhiều nhất"+
                "\n\t\t\t11.Xuất tổng THU NHẬP của từng Giám Đốc"+
                "\n\t\t\tNhập số bất kì khác để thoát");
    }

    //thông báo thêm xóa
    public static void thongBaoThemXoa() {
        System.out.println("\tBạn muốn:"+"\n\t\t1.Thêm nhân viên"+
                "\n\t\t2.Xóa nhân viên"+
                "\n\t\t3.Thêm trưởng phòng"+
                "\n\t\t4.Xóa trưởng phòng"+
                "\n\t\t5.Thêm giám đốc"+
                "\n\t\t6.Xóa giám đốc"+
                "\n\t\tNhập số bất kì khác để hủy"+
                "\n\tNhập lựa chọn: ");
    }
}