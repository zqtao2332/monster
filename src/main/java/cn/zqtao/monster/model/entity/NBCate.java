package cn.zqtao.monster.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 文章分类表
 */
@Data
@Entity
@Table(name = "nb_cate")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NBCate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, length = 11)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotEmpty
    private String name;

    @Column(length = 50)
    @NotEmpty
    private String cnName;

    private String fontIcon;

}
