package com.vshtd.parceldelivery.profile.model.ctx;

import com.vshtd.parceldelivery.profile.model.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
public class Ctx {

    public static final String ROLE = "role";

    @Builder.Default
    private Map<Object, Object> attrs = new HashMap<>();

    public void set(Object key, Object value) {
        attrs.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Object key) {
        return (T) attrs.get(key);
    }

    public Role getRole() {
        return get(ROLE);
    }

    public void setRole(Role role) {
        set(ROLE, role);
    }
}
