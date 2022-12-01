import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //khai báo biến, đối tượng
        Scanner scan = new Scanner(System.in);
        SinhVien sv = new SinhVien();
        boolean flag = false;

        //code xử lý
        do {
            //thông báo
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
                    //Input
                    sv.nhapSinhVien();
                    break;
                case 2:
                    //gọi hàm tính đtb(nếu ko chọn sẽ ko tính đtb khi xuất)
                    sv.tinhDiemTrungBinh();
                    break;
                case 3:
                    //gọi hàm xếp loại(nếu không chọn sẽ xuất ra chưa xếp loại)
                    sv.xepLoai();
                    break;
                case 4:
                    //Output
                    sv.xuatSinhVien();
                    break;
                default:
                    //thông báo chương trình kết thúc
                    System.out.println("Thoát chương trình");
                    flag = true;
                    break;
            }
        }while(!flag);
    }
}
