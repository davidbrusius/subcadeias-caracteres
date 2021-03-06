/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import subcadeiascaracteres.PadraoP;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import subcadeiascaracteres.SubcadeiasCaracteres;

/**
 *
 * @author davidbrusius
 */
public class SubcadeiasCaracteresJUnitTest {

    public SubcadeiasCaracteresJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IOException.class)
    public void lerArquivoDNAShouldThrowIOExceptionWhenPathIsInvalid() throws IOException {
        String invalidPath = "/Users/test.txt";
        SubcadeiasCaracteres.lerArquivoDNA(invalidPath);
    }

    @Test
    public void lerArquivoDNAShouldReturnFileContentForSimpleLineFile() throws IOException {
        String pathToSingleLineFile = "/home/davidbrusius/NetBeansProjects/SubcadeiasCaracteres/test/files/single_line_test.txt";
        String fileContent = SubcadeiasCaracteres.lerArquivoDNA(pathToSingleLineFile);
        assertEquals("must return file content as string", "agttgttagtctacgtggaccgacaaagacagattctttgaggaagctaagcttaacgta", fileContent);
    }

    @Test
    public void lerArquivoDNAShouldReturnFileContentForMultiLineFile() throws IOException {
        String pathToMultipleLineFile = "/home/davidbrusius/NetBeansProjects/SubcadeiasCaracteres/test/files/multiple_line_test.txt";
        String fileContent = SubcadeiasCaracteres.lerArquivoDNA(pathToMultipleLineFile);
        assertEquals("must return file content as string", 
                "agttgttagtctacgtggaccgacaaagacagattctttga" + 
                "ggaagctaagcttaacgtagttctaacagttttttaattagag" + 
                 "agcagatctctgatgaataaccaacggaaaaaggcg", fileContent);
    }
    
    @Test
    public void carregarPadroesPShouldReturnAnArrayOfPadraoPElements() throws IOException {
        String[] padroesP = SubcadeiasCaracteres.carregarPadroesP();
        assertEquals("must return an array of String elements", "actgcttctg", padroesP[0]);
        assertEquals("must return an array of String elements", "aggaggctgg", padroesP[1]);
        assertEquals("must return an array of String elements", "tacatgccat", padroesP[2]);
    }   
}
