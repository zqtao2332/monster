package cn.zqtao.monster.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "nb_upload")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NBUpload implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, length = 11)
    private Long id;

    @Column(nullable = false)
    private String diskPath;

    @Column(nullable = false)
    private String virtualPath;

    private LocalDateTime upload;

    @Column(nullable = false, length = 50)
    private String type;
}
