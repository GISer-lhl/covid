package com.example.covid.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuhl
 * @since 2021-01-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Chinadata implements Serializable {

	public static final long serialVersionUID=1L;

    @TableField("Province")
    public String Province;

    @TableField("Country")
    public String Country;

    @TableField("Date")
    public String Date;

    @TableField("Confirmed")
    public Integer Confirmed;

    @TableField("Deaths")
    public Integer Deaths;

    @TableField("Recovered")
    public Integer Recovered;

    @TableField("Latitude")
    public Double Latitude;

    @TableField("Longitude")
    public Double Longitude;


}
