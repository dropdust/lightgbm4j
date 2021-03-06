package io.github.metarank.lightgbm4j;

import io.github.metarank.lightgbm4j.LGBMDataset;
import io.github.metarank.lightgbm4j.LGBMException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LGBMDatasetTest {
    @Test
    public void testCreateFromFileFail() {
        Assertions.assertThrows(LGBMException.class, () -> {
            LGBMDataset.createFromFile("whatever", "");
        });
    }

    @Test void testCreateFromFile() {
        Assertions.assertDoesNotThrow( () -> {
            LGBMDataset.createFromFile("./src/test/resources/categorical.data", "");
        });
    }

    @Test void testCreateFromMatFloat() {
        Assertions.assertDoesNotThrow( () -> {
            LGBMDataset.createFromMat(new float[] {1.0f, 1.0f, 1.0f, 1.0f}, 2, 2, true, "");
        });
    }

    @Test void testCreateFromMatDouble() {
        Assertions.assertDoesNotThrow( () -> {
            LGBMDataset.createFromMat(new double[] {1.0f, 1.0f, 1.0f, 1.0f}, 2, 2, true, "");
        });
    }

    @Test void testGetNumData() throws LGBMException {
        LGBMDataset ds = LGBMDataset.createFromMat(new float[] {1.0f, 1.0f, 1.0f, 1.0f}, 2, 2, true, "");
        assertEquals(2, ds.getNumData());
        ds.close();
    }

    @Test void testGetNumFeature() throws LGBMException {
        LGBMDataset ds = LGBMDataset.createFromMat(new float[] {1.0f, 1.0f, 1.0f, 1.0f}, 2, 2, true, "");
        assertEquals(2, ds.getNumFeatures());
        ds.close();
    }

    @Test void testSetFeatureNames() throws LGBMException {
        LGBMDataset ds = LGBMDataset.createFromMat(new float[] {1.0f, 1.0f, 1.0f, 1.0f}, 2, 2, true, "");
        Assertions.assertDoesNotThrow( () -> {
            ds.setFeatureNames(new String[] {"foo", "bar"});
        });
        ds.close();
    }
}
