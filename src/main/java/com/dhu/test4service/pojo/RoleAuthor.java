package com.dhu.test4service.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel("角色-权限对应表实体类")
@Entity
@Table(name = "role_author", schema = "Test4", catalog = "")
public class RoleAuthor {
    @ApiModelProperty("对应关系id")
    private int id;
    @ApiModelProperty("角色")
    private Role roleByRoleId;
    @ApiModelProperty("权限")
    private Authority authorityByAuthorId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleAuthor that = (RoleAuthor) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    public Authority getAuthorityByAuthorId() {
        return authorityByAuthorId;
    }

    public void setAuthorityByAuthorId(Authority authorityByAuthorId) {
        this.authorityByAuthorId = authorityByAuthorId;
    }
}
