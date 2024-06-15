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
@Table(name = "PHONGBAN")
public class PhongBan {
    @Id
    @NotNull
    @Size(max = 2)
    @Column(name = "ma_Phong", unique = true)
    private String maPhong;

    @NotNull
    @Size(max = 30)
    @Column(name = "ten_Phong")
    private String tenPhong;


}
