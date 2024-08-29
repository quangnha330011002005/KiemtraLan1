package De01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QLCauThu {
    private ArrayList<CauThu> danhSachCauThu;

    public QLCauThu() {
        danhSachCauThu = new ArrayList<>();
        // Khởi tạo danh sách cầu thủ với dữ liệu mẫu
        danhSachCauThu.add(new CauThu(5, "Nguyen Van A", 1995, 10000000, 200000, 1000));
        danhSachCauThu.add(new CauThu(6, "Nguyen Van B", 1995, 20000000, 200000, 1000));
        danhSachCauThu.add(new CauThu(7, "Nguyen Van C", 1994, 30000000, 200000, 1000));
        danhSachCauThu.add(new CauThu(10, "Nguyen Van D", 1996, 50000000, 200000, 1000));
        danhSachCauThu.add(new CauThu(11, "Nguyen Van E", 1995, 90000000, 200000, 1000));
        danhSachCauThu.add(new CauThu(15, "Nguyen Van F", 1995, 40000000, 200000, 1000));
        danhSachCauThu.add(new CauThu(19, "Nguyen Van G", 1996, 60000000, 200000, 1000));
        danhSachCauThu.add(new CauThu(20, "Nguyen Van H", 1993, 110000000, 200000, 1000));
        danhSachCauThu.add(new CauThu(23, "Nguyen Van M", 1997, 80000000, 200000, 1000));
        danhSachCauThu.add(new CauThu(100, "Nguyen Van N", 1998, 60000000, 200000, 1000));
        danhSachCauThu.add(new CauThu(50, "Nguyen Van Z", 1999, 100000000, 200000, 1000));
    }

    public boolean themCauThu(CauThu cauThu) {
        for (CauThu ct : danhSachCauThu) {
            if (ct.soao()== cauThu.soao()) {
                return false; // Số áo đã tồn tại
            }
        }
        danhSachCauThu.add(cauThu);
        return true;
    }

    public void xuatThongTinCauThu() {
        for (CauThu ct : danhSachCauThu) {
            System.out.println(ct);
        }
        System.out.println("Tổng tiền lương CLB phải trả: " + tinhTongLuong());
    }

    private double tinhTongLuong() {
        double tongLuong = 0;
        for (CauThu ct : danhSachCauThu) {
            tongLuong += ct.getLuongThuc();
        }
        return tongLuong;
    }

    public ArrayList<CauThu> timCauThuLuongCaoNhat() {
        ArrayList<CauThu> cauThuLuongCaoNhat = new ArrayList<>();
        double luongCaoNhat = 0;
        for (CauThu ct : danhSachCauThu) {
            if (ct.getLuongThuc()> luongCaoNhat) {
                luongCaoNhat = ct.getLuongThuc();
            }
        }
        for (CauThu ct : danhSachCauThu) {
            if (ct.getLuongThuc()== luongCaoNhat) {
                cauThuLuongCaoNhat.add(ct);
            }
        }
        return cauThuLuongCaoNhat;
    }

    public void sapXepTheoLuong() {
        Collections.sort(danhSachCauThu, new Comparator<CauThu>() {
            @Override
            public int compare(CauThu ct1, CauThu ct2) {
                return Double.compare(ct1.getLuongThuc(), ct2.getLuongThuc());
            }
        });
    }

    public double tinhLuongTrungBinh() {
        if (danhSachCauThu.isEmpty()) return 0;
        return tinhTongLuong() / danhSachCauThu.size();
    }
}
