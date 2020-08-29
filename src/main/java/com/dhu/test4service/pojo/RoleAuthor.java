package com.dhu.test4service.pojo;

import javax.persistence.*;

@Entity
@Table(name = "role_author", schema = "Test4", catalog = "")
public class RoleAuthor {
    private int id;
    private Role roleByRoleId;
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
