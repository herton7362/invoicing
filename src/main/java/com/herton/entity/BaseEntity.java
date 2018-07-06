package com.herton.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herton.common.utils.IteratorUtils;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity implements Cloneable, Serializable {
    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date updatedDate;
    private Boolean logicallyDeleted = false;
    private Integer sortNumber;
    @Column(length = 128)
    private String clientId;
    @Column(length = 36)
    private String createUserId;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false ;
        else{
            if (obj instanceof BaseEntity){
                BaseEntity e = (BaseEntity) obj;
                return e.id.equals(this.id) ;
            }
        }
        return false ;
    }

    public static <E extends BaseEntity> boolean compare(List<E> l1, List<E> l2) {
        String[] array1 = new String[l1.size()];
        String[] array2 = new String[l2.size()];
        IteratorUtils.forEach(l1, (index, l) ->array1[index] = l.getId());
        IteratorUtils.forEach(l2, (index, l) ->array2[index] = l.getId());
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }
}
