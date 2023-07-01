package com.ccty.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 张峰
 * @since 2023-07-02
 */
@Getter
@Setter
  @TableName("t_user")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

      /**
     * ID主键
     */
        private Integer id;

      /**
     * 姓名
     */
      private String name;

      /**
     * 性别
     */
      private String sex;

      /**
     * 年龄
     */
      private Integer age;


}
