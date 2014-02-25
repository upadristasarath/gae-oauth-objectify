package com.veersoft.server.boundary;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.veersoft.server.boundary.exception.OAuthProviderException;
import com.veersoft.server.control.Provider;
import com.veersoft.server.control.FactoryProvider;

/**
 * User: hal
 * Date: 13.06.2011
 * Time: 19:00:49
 */
public class OAuthService {

    private Log log = LogFactory.getLog(getClass());

    public OAuthUser addAuthorizationUrl(OAuthUser user) {
        log.info("Calling addAuthorizationUrl with oAuthType: " + user.getOAuthType());
        OAuthType oAuthType = user.getOAuthType();

        Provider provider = FactoryProvider.getProvider(oAuthType);

        provider.buildRedirectUrl(user);

        return user;
    }

    public OAuthUser readingUserData(OAuthUser user)
            throws OAuthProviderException {
        log.info("Calling readingUserData with oAuthType: " + user.getOAuthType());
        OAuthType oAuthType = user.getOAuthType();

        Provider provider = FactoryProvider.getProvider(oAuthType);

        provider.readUserData(user);

        return user;
    }

}
