package Demo.Ecommerce.DTO;


import lombok.Data;
import org.jspecify.annotations.Nullable;

import java.util.UUID;
@Data
public class LoginDTOReq {
    private UUID userId;
    private String provider;
    private String providerUserId;

}
