package iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Dienthoai")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int madt;

    private String tendt;

    @Column(length = 4)
    private String namsanxuat;

    @Column(length = 255)
    private String cauhinh;

    private String hinhanh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mancc")
    private NhaCungCap ncc;
}
