package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LottoNoTest {
    @Test
    public void 로또번호입력시처리여부Test() {
        assertEquals(1, new LottoNo(1).getLottoNo());
        assertEquals(45, new LottoNo(45).getLottoNo());
        assertEquals(0, new LottoNo(0).getLottoNo());
        assertEquals(47, new LottoNo(47).getLottoNo());
    }

}
