package com.example.demo.cmm.enm;

public enum Path {
    DEFAULT_PROTFILE;
    @Override
    public String toString() {
        String result = "";
        switch(this) {
            case DEFAULT_PROTFILE:
                result = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiuZGp08DDSD0P3PMfKSbbPu2nVmJdH74gHg&usqp=CAU";
        }
        return result;
    }
}