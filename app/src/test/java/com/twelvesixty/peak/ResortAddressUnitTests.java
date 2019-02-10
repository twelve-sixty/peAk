package com.twelvesixty.peak;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResortAddressUnitTests {

    @Test
    public void resortAddressGettersAndSetters_Test1() {
        ResortAddress fakeResortAddress = new ResortAddress();

        fakeResortAddress.setLine1("US-2");
        fakeResortAddress.setLine2("PO Box 555");
        fakeResortAddress.setCity("Skykomish");
        fakeResortAddress.setState("WA");
        fakeResortAddress.setZipcode(98119);

        assertEquals(fakeResortAddress.getLine1(), "US-2");
        assertEquals(fakeResortAddress.getLine2(), "PO Box 555");
        assertEquals(fakeResortAddress.getCity(), "Skykomish");
        assertEquals(fakeResortAddress.getState(), "WA");
        assertEquals(fakeResortAddress.getZipcode(), 98119);

    }

    @Test
    public void resortAddressGettersAndSetters_Tests2() {
        ResortAddress fakeResortAddress = new ResortAddress();

        fakeResortAddress.setLine1("I-90");
        fakeResortAddress.setLine2("PO Box 777");
        fakeResortAddress.setCity("Snoqualmie");
        fakeResortAddress.setState("WA");
        fakeResortAddress.setZipcode(98117);

        assertEquals(fakeResortAddress.getLine1(), "I-90");
        assertEquals(fakeResortAddress.getLine2(), "PO Box 777");
        assertEquals(fakeResortAddress.getCity(), "Snoqualmie");
        assertEquals(fakeResortAddress.getState(), "WA");
        assertEquals(fakeResortAddress.getZipcode(), 98117);

    }

    @Test
    public void resortAddressGettersAndSetters_Tests3() {
        ResortAddress fakeResortAddress = new ResortAddress();

        fakeResortAddress.setLine1("I-5");
        fakeResortAddress.setLine2("PO Box 888");
        fakeResortAddress.setCity("Mammoth");
        fakeResortAddress.setState("CA");
        fakeResortAddress.setZipcode(93546);

        assertEquals(fakeResortAddress.getLine1(), "I-5");
        assertEquals(fakeResortAddress.getLine2(), "PO Box 888");
        assertEquals(fakeResortAddress.getCity(), "Mammoth");
        assertEquals(fakeResortAddress.getState(), "CA");
        assertEquals(fakeResortAddress.getZipcode(), 93546);

    }
}
