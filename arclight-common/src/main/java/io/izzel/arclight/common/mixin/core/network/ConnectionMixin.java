package io.izzel.arclight.common.mixin.core.network;

import com.mojang.authlib.properties.Property;
import io.izzel.arclight.common.bridge.core.network.NetworkManagerBridge;
import io.netty.channel.Channel;
import net.minecraft.network.Connection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.UUID;

@Mixin(Connection.class)
public class ConnectionMixin implements NetworkManagerBridge {

    @Shadow public Channel channel;
    public java.util.UUID spoofedUUID;
    public com.mojang.authlib.properties.Property[] spoofedProfile;
    public String hostname;

    @Override
    public UUID bridge$getSpoofedUUID() {
        return spoofedUUID;
    }

    @Override
    public void bridge$setSpoofedUUID(UUID spoofedUUID) {
        this.spoofedUUID = spoofedUUID;
    }

    @Override
    public Property[] bridge$getSpoofedProfile() {
        return spoofedProfile;
    }

    @Override
    public void bridge$setSpoofedProfile(Property[] spoofedProfile) {
        this.spoofedProfile = spoofedProfile;
    }

    @Override
    public String bridge$getHostname() {
        return hostname;
    }

    @Override
    public void bridge$setHostname(String hostname) {
        this.hostname = hostname;
    }
}
