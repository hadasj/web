package org.demo.client;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.demo.Config;

public class AzureKeyVaultClient {

	private final SecretClient client = new SecretClientBuilder()
			.vaultUrl(Config.getKeyVaultUri())
			.credential(new DefaultAzureCredentialBuilder().build())
			.buildClient();

	public String readSecret(final String secretName) {
		final KeyVaultSecret secret = client.getSecret(secretName);
		if (secret != null) {
			return secret.getValue();
		}
		throw new IllegalArgumentException("Secret \"" + secretName + "\" wasn't found");
	}
}
