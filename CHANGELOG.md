## 2.0pre4 Changelog

### Bug Fixes
- **Iron Fence crash** -- Fixed crash when placing two Iron Fences next to each other - resolves an `IllegalAccessError` from accessing a private method on `WallBlock`. ([#73](https://github.com/starfish-studios/Building-But-Better/issues/73), [#75](https://github.com/starfish-studios/Building-But-Better/issues/75), [#76](https://github.com/starfish-studios/Building-But-Better/issues/76))
- **Invalid Rotation -90.0** -- Fixed a rotation in a random unused model that was throwing errors. ([#66](https://github.com/starfish-studios/Building-But-Better/issues/66))
- **Moulding Models** -- Fixed template model so it uses the proper texture mappings - outer corners with dentils toggled off should now have the appropriate texture instead of showing Stone.
- **Cut Copper Layer** -- Cut Copper Layers now support waxing, unwaxing, and scraping like Vanilla Copper blocks. ([#69](https://github.com/starfish-studios/Building-But-Better/issues/69))
- **Mipmapping** -- Addressed mipmapping issues. ([#65](https://github.com/starfish-studios/Building-But-Better/issues/65)) _- found some others too, skimmed logs and didn't see any remaining so hopefully this is good now?_

### Other
- **Misc. Recipes** -- Added missing recipes for Chisel, all Stone Frames, Balustrades, and Lattices. ([#67](https://github.com/starfish-studios/Building-But-Better/issues/67), [#68](https://github.com/starfish-studios/Building-But-Better/issues/68), [#70](https://github.com/starfish-studios/Building-But-Better/issues/70), [#72](https://github.com/starfish-studios/Building-But-Better/issues/72)) 
- **Wooden Fuel Items** — Wooden BBB items can now be used as Furnace fuel with the burn time of Sticks - 1 BBB item can smelt 1 item _because I am lazy and did not want to figure out individual values for everything_. ([#61](https://github.com/starfish-studios/Building-But-Better/issues/61))
- **Polished Stone** blockstate now "supports" a middle state

_As always, please report issues on GitHub or our Discord server and I will tackle them as soon as I can!_
