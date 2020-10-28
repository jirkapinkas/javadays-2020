package com.example.helloworld.entity.priklad4;

import javax.persistence.Entity;

@Entity
public class Note extends BaseNote {

    private String internalMemo;

    public String getInternalMemo() {
        return internalMemo;
    }

    public void setInternalMemo(String internalMemo) {
        this.internalMemo = internalMemo;
    }
}
