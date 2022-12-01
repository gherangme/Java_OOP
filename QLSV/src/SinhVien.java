import java.util.Scanner;

public class SinhVien {
    //khai báo thuộc tính
    private String tenSV;
    private int maSV;
    private float diemToan;
    private float diemLy;
    private float diemHoa;
    private float diemTB = 0;
    private String xepLoai = "Chưa xếp loại";

    //hàm khởi tạo
    public SinhVien() {
    }

    public SinhVien(String tenSV, int maSV, float diemToan, float diemLy, float diemHoa, float diemTB, String xepLoai) {
        this.tenSV = tenSV;
        this.maSV = maSV;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
        this.diemTB = diemTB;
        this.xepLoai = xepLoai;
    }

    //getter setter
    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public float getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(float diemToan) {
        this.diemToan = diemToan;
    }

    public float getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(float diemLy) {
        this.diemLy = diemLy;
    }

    public float getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(float diemHoa) {
        this.diemHoa = diemHoa;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    //hàm xử lý nhập
    public void nhapSinhVien() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vui lòng nhập vào tên sinh viên: ");
        this.tenSV = scan.nextLine();
        System.out.println("Vui lòng nhập vào mã sinh vien: ");
        this.maSV = Integer.parseInt(scan.nextLine());
        System.out.println("Vui lòng nhập vào điểm toán: ");
        this.diemToan = Float.parseFloat(scan.nextLine());
        if(this.diemToan <0 || this.diemToan > 10) {
            do {
                System.out.println("Vui lòng nhập điểm toán 0-10: ");
                this.diemToan = Float.parseFloat(scan.nextLine());
            }while(this.diemToan<0 || this.diemToan>10);
        }

        System.out.println("Vui lòng nhập vào điểm lý");
        this.diemLy = Float.parseFloat(scan.nextLine());
        if(this.diemLy <0 || this.diemLy > 10) {
            do {
                System.out.println("Vui lòng nhập điểm lý 0-10: ");
                this.diemLy = Float.parseFloat(scan.nextLine());
            }while(this.diemLy<0 || this.diemLy>10);
        }

        System.out.println("Vui lòng nhập vào điểm hóa");
        this.diemHoa = Float.parseFloat(scan.nextLine());
        if(this.diemHoa <0 || this.diemHoa > 10) {
            do {
                System.out.println("Vui lòng nhập điểm hóa 0-10: ");
                this.diemHoa = Float.parseFloat(scan.nextLine());
            }while(this.diemHoa<0 || this.diemHoa>10);
        }
        System.out.println("Hoàn thành nhập");
    }

    //hàm tính điểm trung bình
    public float tinhDiemTrungBinh() {
        System.out.println("Hoàn tất tính điểm trung bình");
        this.diemTB = (this.diemToan + this.diemLy + this.diemHoa)/3;
        return this.diemTB;
    }

    //hàm xếp loại
    public String xepLoai() {
        System.out.println("Hoàn tất xếp loại");
        if(this.diemTB >= 9) {
            return this.xepLoai = "Xuất sắc";
        }else if(this.diemTB >=8 && this.diemTB <9) {
            return this.xepLoai = "Giỏi";
        }else if(this.diemTB >=7 && this.diemTB <8) {
            return this.xepLoai = "Khá";
        }else if(this.diemTB >=6 && this.diemTB <7) {
            return this.xepLoai = "Trung bình khá";
        }else if(this.diemTB >=5 && this.diemTB <6) {
            return this.xepLoai = "Trung bình";
        }else {
            return this.xepLoai = "Yếu";
        }
    }

    //hàm xuất
    public void xuatSinhVien() {
        System.out.println("\tTên: "+this.tenSV+
                "\n\tMã: "+this.maSV+
                "\n\tToán: "+this.diemToan+
                "\n\tLý: "+this.diemLy+
                "\n\tHóa: "+this.diemHoa+
                "\n\tĐTB: "+this.diemTB+
                "\n\tXL: "+this.xepLoai);
        System.out.println("--------------------------------------------------------------------------");
    }
}
