package net.genesishub.gFeatures.Feature.gDestroyCritical;

import net.genesishub.gFeatures.Basic;
import net.genesishub.gFeatures.Configs;

public class Configure {
	@Configs
	public static void onSetup(){
		gDestroyCritical base = new gDestroyCritical("gDestroyCritical", "1.0.0");
		Basic.addFeature(base);
	}
}
