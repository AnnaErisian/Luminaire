import sys

recipe = "{{\n  \"result\": {{\n    \"item\": \"luminaire:{lowMaterial}_orb_chalice_{lowColor}\",\n    \"count\": 1\n  }},\n  \"pattern\": [\n    \"T\",\n    \"D\"\n  ],\n  \"type\": \"forge:ore_shaped\",\n  \"key\": {{\n    \"T\": {{\n      \"item\": \"minecraft:glass\"\n    }},\n    \"D\": {{\n      \"item\": \"luminaire:{lowMaterial}_flame_chalice_{lowColor}\",\n      \"data\": 0\n    }}\n  }}\n}}"
recipe_f = "./recipes/{lowMaterial}_chalice_upgrade_{lowColor}.json"
torchTypes = ["bone", "gold", "shadow", "silver"]
colors = ["white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "silver", "cyan", "purple", "blue", "brown", "green", "red", "black"]


for material in torchTypes:
    for color in colors:
        f = open(recipe_f.format(lowMaterial=material, lowColor=color), "w")
        f.write(recipe.format(lowMaterial=material, lowColor=color))
        f.close()