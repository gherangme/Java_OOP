import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SinhVien sv = new SinhVien();
        boolean flag = false;
        do {
            System.out.println();
            System.out.println("\t\t\t\t\t\t\tQUẢN LÝ SINH VIÊN");
            System.out.println("\t\t\t\t\t\t1.Nhập sinh viên");
            System.out.println("\t\t\t\t\t\t2.Tính điểm trung bình");
            System.out.println("\t\t\t\t\t\t3.Xếp loại");
            System.out.println("\t\t\t\t\t\t4.Xuất thông tin sinh viên");
            System.out.println("\t\t\t\t\t\tNhập số bất kì khác để thoát");
            System.out.println("Vui lòng chọn chức năng: ");
            int chon = Integer.parseInt(scan.nextLine());
            switch (chon) {
                case 1:
                    sv.nhapSinhVien();
                    break;
                case 2:
                    sv.tinhDiemTrungBinh();
                    break;
                case 3:
                    sv.xepLoai();
                    break;
                case 4:
                    sv.xuatSinhVien();
                    break;
                default:
                    System.out.println("Thoát chương trình");
                    flag = true;
                    break;
            }
        }while(!flag);
    }
}