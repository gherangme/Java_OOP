import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DanhSachChuyenXe dscx = new DanhSachChuyenXe();
        boolean flag = false;
        do {
            System.out.println("\t\t\t\t\t\tQUẢN LÝ CHUYẾN XE"+
                    "\n\t\t\t1.Nhập chuyến xe nội thành"+
                    "\n\t\t\t2.Nhập chuyến xe ngoại thành"+
                    "\n\t\t\t3.Xuất danh sách các chuyến xe"+
                    "\n\t\t\t4.Tính tổng doanh thu nội thành, ngoại thành"+
                    "\n\t\t\t5.Xuất tổng doanh thu nội thành, ngoại thành"+
                    "\n\t\t\t6.Xuất tổng doanh thu"+
                    "\n\t\t\tNhập số bất kỳ khác để thoát"+
                    "\n\t\tVui lòng chọn chức năng");
            int chon = Integer.parseInt(scan.nextLine());
            switch (chon) {
                case 1:
                    ChuyenXe chuyenXeNoiThanh = new ChuyenXeNoiThanh();
                    chuyenXeNoiThanh.nhap();
                    chuyenXeNoiThanh.tinhDoanhThu();
                    dscx.themChuyenXe(chuyenXeNoiThanh);
                    break;
                case 2:
                    ChuyenXe chuyenXeNgoaiThanh = new ChuyenXeNgoaiThanh();
                    chuyenXeNgoaiThanh.nhap();
                    chuyenXeNgoaiThanh.tinhDoanhThu();
                    dscx.themChuyenXe(chuyenXeNgoaiThanh);
                    break;
                case 3:
                    dscx.xuatChuyenXe();
                    break;
                case 4:
                    dscx.tinhTongDoanhThuNoiThanh();
                    dscx.tinhTongDoanhThuNgoaiThanh();
                    System.out.println("Hoàn tất tính doanh thu");
                    break;
                case 5:
                    System.out.println("Tổng doanh thu nội thành: "+dscx.getTongDoanhThuNoiThanh());
                    System.out.println("Tổng doanh thu ngoại thành: "+dscx.getTongDoanhThuNgoaiThanh());
                    break;
                case 6:
                    dscx.tinhTongDoanhThu();
                    break;
                default:
                    System.out.println("Thoát chương trình");
                    flag = true;
                    break;
            }
        }while (!flag);
    }
}