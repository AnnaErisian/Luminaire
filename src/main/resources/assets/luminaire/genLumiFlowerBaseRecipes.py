import sys

recipe = "{{\n  \"result\": {{\n    \"item\": \"luminaire:gf_{flower}\",\n    \"count\": 8\n  }},\n  \"pattern\": [\n    \"TTT\",\n    \"TDT\",\n    \"TTT\"\n  ],\n  \"type\": \"forge:ore_shaped\",\n  \"key\": {{\n    \"T\": {{\n      \"item\": \"{flower}\"\n    }},\n    \"D\": {{\n      \"item\": \"#GLOWDUST\"\n    }}\n  }}\n}}"
recipe_f = "./recipes/glow_flower_{flower}.json"
flowers = ["dandelion", "poppy", "orchid", "allium", "houstonia", "red_tulip", "orange_tulip", "white_tulip", "pink_tulip", "daisy", "clover", "swampflower", "glowflower", "blue_hydrangea", "orange_cosmos", "pink_daffodil", "wildflower", "violet", "white_anemone", "pink_hibiscus", "lily_of_the_valley", "lavender", "goldenrod", "bluebells", "icy_iris", "rose", "bromeliad", "miners_delight"]


for flowerName in flowers:
    f = open(recipe_f.format(flower=flowerName), "w")
    f.write(recipe.format(flower=flowerName))
    f.close()