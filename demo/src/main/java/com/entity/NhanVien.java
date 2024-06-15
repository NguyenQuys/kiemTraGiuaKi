package com.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @Size(max = 3)
    @NotBlank
    @Column(name = "ma_NV", unique = true)
    private String maNV;

    @NotBlank
    @Size(max = 100)
    @Column(name = "ten_NV")
    private String tenNV;

    @Size(max = 3)
    @Column(name = "phai")
    private String phai;

    @Size(max = 200)
    @Column(name = "noi_Sinh")
    private String noiSinh;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_Phong", referencedColumnName = "ma_Phong")
    private PhongBan phongBan;

    @Column(name = "luong")
    private Integer luong;
}
