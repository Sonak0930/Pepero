package Projectile;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Pose;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Skill_Chaos_Projectile implements  Fireball{

	@Override
	public boolean doesBounce() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public @Nullable ProjectileSource getShooter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBounce(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setShooter(@Nullable ProjectileSource arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addPassenger(@NotNull Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addScoreboardTag(@NotNull String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eject() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public @NotNull BoundingBox getBoundingBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEntityId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public @NotNull BlockFace getFacing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getFallDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFireTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public @Nullable EntityDamageEvent getLastDamageCause() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NotNull Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Location getLocation(@Nullable Location arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxFireTicks() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public @NotNull List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Entity getPassenger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NotNull List<Entity> getPassengers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NotNull PistonMoveReaction getPistonMoveReaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPortalCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public @NotNull Pose getPose() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NotNull Set<String> getScoreboardTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NotNull Server getServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTicksLived() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public @NotNull EntityType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NotNull UUID getUniqueId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable Entity getVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NotNull Vector getVelocity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public @NotNull World getWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasGravity() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCustomNameVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGlowing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInsideVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInvulnerable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOnGround() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPersistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSilent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean leaveVehicle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void playEffect(@NotNull EntityEffect arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removePassenger(@NotNull Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeScoreboardTag(@NotNull String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCustomNameVisible(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFallDistance(float arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFireTicks(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGlowing(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGravity(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInvulnerable(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastDamageCause(@Nullable EntityDamageEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setPassenger(@NotNull Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPersistent(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPortalCooldown(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRotation(float arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSilent(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTicksLived(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVelocity(@NotNull Vector arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public @NotNull Spigot spigot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean teleport(@NotNull Location arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(@NotNull Entity arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(@NotNull Location arg0, @NotNull TeleportCause arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teleport(@NotNull Entity arg0, @NotNull TeleportCause arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public @NotNull List<MetadataValue> getMetadata(@NotNull String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMetadata(@NotNull String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeMetadata(@NotNull String arg0, @NotNull Plugin arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMetadata(@NotNull String arg0, @NotNull MetadataValue arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public @NotNull String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessage(@NotNull String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(@NotNull String[] arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public @NotNull PermissionAttachment addAttachment(@NotNull Plugin arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable PermissionAttachment addAttachment(@NotNull Plugin arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NotNull PermissionAttachment addAttachment(@NotNull Plugin arg0, @NotNull String arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @Nullable PermissionAttachment addAttachment(@NotNull Plugin arg0, @NotNull String arg1, boolean arg2,
			int arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public @NotNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPermission(@NotNull String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasPermission(@NotNull Permission arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPermissionSet(@NotNull String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPermissionSet(@NotNull Permission arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recalculatePermissions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttachment(@NotNull PermissionAttachment arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOp(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public @Nullable String getCustomName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCustomName(@Nullable String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public @NotNull PersistentDataContainer getPersistentDataContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public float getYield() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isIncendiary() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setIsIncendiary(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setYield(float arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public @NotNull Vector getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDirection(@NotNull Vector arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
