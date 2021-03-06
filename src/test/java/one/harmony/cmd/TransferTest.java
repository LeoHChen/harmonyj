package one.harmony.cmd;

import org.junit.jupiter.api.Test;

public class TransferTest {
	private static final int LOCAL_NET = 2;

	public void testImportPrivateKey() throws Exception {
		String key = "fd416cb87dcf8ed187e85545d7734a192fc8e976f5b540e9e21e896ec2bc25c3";
		String accountName = "a1";
		Keys.importPrivateKey(key, accountName);
	}

	@Test
	public void testTransfer() throws Exception {
		Keys.cleanKeyStore();
		testImportPrivateKey();
		String from = "one1pdv9lrdwl0rg5vglh4xtyrv3wjk3wsqket7zxy"; // Harmony localnet addresses
		String to = "one1pf75h0t4am90z8uv3y0dgunfqp4lj8wr3t5rsp"; // Harmony localnet addresses
		String amount = "50.714285714";
		int fromShard = 0;
		int toShard = 1;
		boolean dryRun = false;
		int waitToConfirmTime = 0;
		String passphrase = "harmony-one";
		String memo = "0x5061796d656e7420666f722078797a";
		new Transfer(from, to, amount, fromShard, toShard, memo).execute(LOCAL_NET, passphrase, dryRun,
				waitToConfirmTime);
		Keys.cleanKeyStore();
	}

}
