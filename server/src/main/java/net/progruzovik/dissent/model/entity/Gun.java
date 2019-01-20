package net.progruzovik.dissent.model.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Gun {

    public static final int NO_GUN_ID = -1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int shotCost;

    @Column(nullable = false)
    private int damage;

    @Column(nullable = false)
    private int radius;

    @Column(nullable = false)
    private float accuracy;

    @ManyToOne
    @JoinColumn(name = "gun_type_id", nullable = false)
    private GunType type;

    @ManyToOne
    @JoinColumn(name = "texture_id", nullable = false)
    private Texture texture;

    public Gun(int id, @NonNull String name, int shotCost, int damage, int radius,
               float accuracy, @NonNull GunType type, @NonNull Texture texture) {
        this.id = id;
        this.name = name;
        this.shotCost = shotCost;
        this.damage = damage;
        this.radius = radius;
        this.accuracy = accuracy;
        this.type = type;
        this.texture = texture;
    }

    Gun() { }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public int getShotCost() {
        return shotCost;
    }

    public int getDamage() {
        return damage;
    }

    public int getRadius() {
        return radius;
    }

    public float getAccuracy() {
        return accuracy;
    }

    @NonNull
    public String getTypeName() {
        return type.getName();
    }

    @NonNull
    public Texture getTexture() {
        return texture;
    }
}
