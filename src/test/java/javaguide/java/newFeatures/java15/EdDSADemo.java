package javaguide.java.newFeatures.java15;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

public class EdDSADemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
        KeyPair kp = kpg.generateKeyPair();

        byte[] msg = "test_string".getBytes(StandardCharsets.UTF_8);

        Signature sig = Signature.getInstance("Ed25519");
        sig.initSign(kp.getPrivate());
        sig.update(msg);
        byte[] s = sig.sign();

        String encodedString = Base64.getEncoder().encodeToString(s);
        System.out.println(encodedString);
    }
}
/*
0Hc0lxxASZNvS52WsvnncJOH/mlFhnA8Tc6D/k5DtAX5BSsNVjtPF4R4+yMWXVjrvB2mxVXmChIbki6goFBgAg==
1u36GDCCQyZkP2IhsqqD2ckuUVZoxQxDeN9InqgvBaYHDC4JetZ6geTH9hC7U20QemXbHMNDeYT0n7TJNqGjCQ==
+R//Kgb1dCWKwow6PJ82Ex+LhEjdhEJoK4co2ZzHlXkiCRc8MKNZ2e9bkRYbjHkGksWK+/q/Hbz0qxjYlcH9Bw==
 */