/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package De01;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QLCauThu qlCauThu = new QLCauThu();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Xuat danh sach cau thu");
            System.out.println("2. Them moi cau thu");
            System.out.println("3. Tìm cau thu co luong thuc cao nhat");
            System.out.println("4. Sap xep");
            System.out.println("5. Tinh luong trung binh cua cac cau thu");
            System.out.println("0. Out");
            System.out.print("Chon chuc nang (0-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng newline còn lại

            switch (choice) {
                case 1:
                    // Xuất thông tin danh sách cầu thủ
                    qlCauThu.xuatThongTinCauThu();
                    break;

                case 2:
                    // Thêm cầu thủ mới
                    System.out.print("Nhap so ao: ");
                    int soAo = scanner.nextInt();
                    scanner.nextLine(); // Đọc dòng newline còn lại

                    System.out.print("Nhap ho ten: ");
                    String hoTen = scanner.nextLine();

                    System.out.print("Nhap nam sinh: ");
                    int namSinh = scanner.nextInt();

                    System.out.print("Nhap luong cung: ");
                    double luongCung = scanner.nextDouble();

                    System.out.print("Nhap tien thuong: ");
                    double tienThuong = scanner.nextDouble();

                    System.out.print("Nhap tien phat: ");
                    double tienPhat = scanner.nextDouble();

                    CauThu cauThu = new CauThu(soAo, hoTen, namSinh, luongCung, tienThuong, tienPhat);
                    if (qlCauThu.themCauThu(cauThu)) {
                        System.out.println("Them cau thu thanh cong!");
                    } else {
                        System.out.println("So ao da ton tai!");
                    }
                    break;

                case 3:
                    // Tìm cầu thủ có lương thực lãnh cao nhất
                    ArrayList<CauThu> caoNhat = qlCauThu.timCauThuLuongCaoNhat();
                    System.out.println("Cau thu co luong thuc cao nhat:");
                    for (CauThu ct : caoNhat) {
                        System.out.println(ct);
                    }
                    break;

                case 4:
                    // Sắp xếp danh sách cầu thủ theo lương thực lãnh tăng dần
                    qlCauThu.sapXepTheoLuong();
                    System.out.println("Danh sach cau thu sap xep tang dan.");
                    break;

                case 5:
                    // Tính lương cứng trung bình
                    double luongTrungBinh = qlCauThu.tinhLuongTrungBinh();
                    System.out.println("Luong cung trung binh cua cac cau thu: " + luongTrungBinh);
                    break;

                case 0:
                    // Thoát
                    System.out.println("Thoat.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Vui long chon lai.");
                    break;
            }
        }
    }
}
